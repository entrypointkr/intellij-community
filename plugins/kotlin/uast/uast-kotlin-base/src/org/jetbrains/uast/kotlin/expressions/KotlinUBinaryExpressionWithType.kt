// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.uast.kotlin

import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtBinaryExpressionWithTypeRHS
import org.jetbrains.uast.*

class KotlinUBinaryExpressionWithType(
    override val sourcePsi: KtBinaryExpressionWithTypeRHS,
    givenParent: UElement?
) : KotlinAbstractUExpression(givenParent), UBinaryExpressionWithType, KotlinUElementWithType, KotlinEvaluatableUElement {
    override val operand by lz {
        baseResolveProviderService.baseKotlinConverter.convertOrEmpty(sourcePsi.left, this)
    }

    override val type by lz {
        sourcePsi.right?.let {
            baseResolveProviderService.resolveToType(it, this, boxed = false)
        } ?: UastErrorType
    }

    override val typeReference by lz {
        sourcePsi.right?.let {
            KotlinUTypeReferenceExpression(it, this) { type }
        }
    }

    override val operationKind = when (sourcePsi.operationReference.getReferencedNameElementType()) {
        KtTokens.AS_KEYWORD -> UastBinaryExpressionWithTypeKind.TypeCast.INSTANCE
        KtTokens.AS_SAFE -> KotlinBinaryExpressionWithTypeKinds.SAFE_TYPE_CAST
        else -> UastBinaryExpressionWithTypeKind.UNKNOWN
    }
}
