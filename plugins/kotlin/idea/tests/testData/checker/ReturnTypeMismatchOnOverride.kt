interface Base {
    fun foo(): Int

    var bar: Int
}

class Derived : Base {

    override fun foo(): <error descr="[RETURN_TYPE_MISMATCH_ON_OVERRIDE] Return type of 'foo' is not a subtype of the return type of the overridden member 'internal abstract fun foo(): kotlin.Int defined in Base'">String</error> = ""

    override var bar: <error descr="[PROPERTY_TYPE_MISMATCH_ON_OVERRIDE] Type of 'bar' doesn't match the type of the overridden var-property 'internal abstract var bar: kotlin.Int defined in Base'">String</error> = ""
}