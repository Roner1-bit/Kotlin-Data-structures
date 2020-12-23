import java.lang.Exception


class QueueAsArray<T>(size: Int) {

    private var currentSize = 0                                                       //queue here is adding elements on the position of the rear then w eincrease the rear by 1.

    private var rear = 0

    private var front = 0


    private val queueArray = arrayOfNulls<kotlin.Any?>(size)





    fun enqueue(element: T) {

        if (currentSize == queueArray.size) {

            throw Exception("Queue is full")

        }

        if (rear > queueArray.size - 1 && currentSize < queueArray.size) {

            rear = 0

        }




        queueArray[rear++]=element                                               //rear is always pointing on the next empty cell.

        currentSize++


    }


    fun dequeue() {

        if (currentSize == 0) {

            throw Exception("Queue is empty.")

        }

        if (front > queueArray.size - 1) {

            front = 0


        }

        val result = queueArray[front++]


        currentSize--

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



    fun printQueue(): String {

        var index = front

        var endOfQueue = rear

        var result: String = ""

        while (index < endOfQueue) {

            result = result + queueArray[index] + " "

            index++
        }

        return result

    }


}