open class StackAsArray<T>(size: Int) {

    private val stackSize: Int = size

    //first element in the array is first element inserted in stack so it will be the last to leave.
    private var top: Int = -1                              // 0 is the index of the first element in stack


    private val stackArray = arrayOfNulls<kotlin.Any?>(size)


    fun isEmpty(): Boolean {

        return this.top == -1
    }


    fun isFull(): Boolean {

        return this.top == stackSize - 1
    }


    fun push(element: T) {

        if (this.isFull()) {

            throw Exception("The stack is full")

        }

        this.top++

        stackArray[this.top] = element

    }


    fun pop(): kotlin.Any? {

        if (this.isEmpty()) {

            throw Exception("The stack is full")
        }

        var element = stackArray[this.top]

        this.top--

        return element

    }


    fun peak(): kotlin.Any? {
        if (this.isEmpty()) {

            throw Exception("This stack is full")
        }

        return stackArray[this.top]

    }


}




