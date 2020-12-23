class QueueAsLinkedList<T>:DoubleLinkedList<T>() {



    private var currentSize = 0                                                       //head will be the front and tail will be the rear.


    var queueList=DoubleLinkedList<T>()


    fun enqueue(element:T){

        queueList.append(element)

        currentSize++

    }


    fun dequeue(){

        queueList.DeleteTail()

        currentSize--


    }


    fun peek(){


        println(queueList.head?.data)


    }

    fun size():Int{
        return currentSize
    }



    fun printQueue(){

        queueList.printAll()

    }


}