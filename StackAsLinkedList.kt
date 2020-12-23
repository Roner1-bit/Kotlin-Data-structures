class StackAsLinkedList<T> (size:Int){

    private val stackSize: Int = size          //peak of the stack is at the linked list tail.

    private var top: Int = -1

    var stack=DoubleLinkedList<T>()


    fun isEmpty(): Boolean {

        return this.top == -1
    }


    fun isFull(): Boolean {

        return this.top == stackSize - 1
    }


    fun push(element:T){
        if (this.isFull()) {

            throw Exception("The stack is full")

        }

        this.top++

        stack.append(element)

    }



    fun pop():T?{

        if (this.isEmpty()) {

            throw Exception("The stack is full")
        }

        val element:T?=stack.tail?.data

        this.top--

        stack.DeleteTail()

        return element

    }



    fun peak():kotlin.Any?{
        if (this.isEmpty()){

            throw Exception("This stack is full")
        }

        val element:T?=stack.tail?.data

        return element


    }

}