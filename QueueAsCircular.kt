import java.lang.Exception

class QueueAsCircular<T>(size: Int) {

    private var currentSize = 0

    private var rear = 0

    private var front = 0

    private val queueArray = arrayOfNulls<kotlin.Any?>(size)


    fun enqueue(element: T) {

        if (currentSize == queueArray.size) {

            throw Exception("Queue is full")

        }

        queueArray[rear] = element

        rear = (rear + 1) % queueArray.size

        currentSize++

    }


    fun dequeue(): Any? {


        if (currentSize == 0) {

            throw Exception("Queue is empty.")

        }


        var element = queueArray[front]

        queueArray[front] = null

        front = (front + 1) % queueArray.size

        currentSize--

        return element


    }


    fun size(): Int {

        return currentSize

    }


    fun peek(): Any? {


        if (currentSize == 0) {

            throw Exception("Queue is empty.")

        }


        return queueArray[front]

    }


    fun printQueue() {

        var result:String=""
                                               //designed this way to print elements.
        for (i in queueArray) {

            if (i == null) {

                continue

            }

            result=result+i+" "


        }

        println(result)

    }


}