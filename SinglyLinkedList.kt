open class SinglyLinkedList<T> {

    class Node<T>(nodeData:T?,nextNode:Node<T>?,previousNode:Node<T>?){

        var data:T?

        get() = field

        var next:Node<T>?


        var previous:Node<T>?



        init{

            data=nodeData

            next=nextNode

            previous=previousNode

        }


        constructor(nodeData:T?,nextNode:Node<T>?):this(nodeData,nextNode,previousNode=null)

    }



    var head:Node<T>?



    var tail:Node<T>?


    init{

        head=null

        tail=null

    }



    fun count():Int{

        var node=head

        var count:Int=1

        if(node == null){

            return 0

        }else{

            while(node?.next!=null){

                count++

                node=node.next

            }
            return count

        }

    }


//Incase of not finding the element the function would return nothing and leave the list as it is.


    fun insertAfterNode(data:T,targetData:T?){

        var newNode=Node(data,null)

        var node=head


        while(node?.data!=targetData){

            if(node == null){

                return

            }

            node=node?.next

        }


        if (node==tail){            //Incase the targetted data was on the tail.

            if(node?.data==targetData){


                newNode?.next=null

                node?.next=newNode

                tail=newNode

            }

            else{

                return

            }

        }else{

            newNode?.next=node?.next

            node?.next=newNode
        }
    }






    fun insertAfterIndex(data:T,index:Int){

        var newNode=Node(data,null)

        var currentIndex:Int=0

        var node=head


        while(currentIndex!=index){

            if(node == null){

                return

            }

            node=node?.next

            currentIndex++

        }


        newNode?.next=node?.next

        node?.next=newNode

        if(node == tail){
            tail=newNode
        }


    }





    fun prepend(data:T){             //Insert element before first element


        var newNode=Node(data,head)



        if(head?.next==null){
            tail=newNode
        }


        head=newNode


    }




    fun DeleteNode(targetData:T){



        var node=head


        while(node?.next?.data!=targetData){

            if(node == null){

                return

            }

            node=node?.next

        }


        if (node?.next==tail){                              //Incase the targetted data was on the tail.

            if(node?.next?.data==targetData){


                node?.next=null

                tail=node

            }

            else{

                return

            }

        }

        var temp=node?.next                                   //Temp is the node we want to remove

        node?.next=temp?.next
    }









    fun DeleteIndex(index:Int){

        var currentIndex:Int=0

        var node=head

        var previousNode=node


        while(currentIndex!=index){


            if(node == null){

                return

            }

            previousNode=node

            node=node?.next

            currentIndex++

        }


        previousNode?.next=node?.next                 //Delete the specified index

        if(node == tail){

            tail=previousNode
        }


    }



    fun DeleteHead(){

        if(head==null){

            return

        }


        head=head?.next

        if(head==null){
            tail=null
        }



    }




    fun printAll(){

        var node = head

        while(node!=tail){


            println(node?.data)

            node=node?.next
        }

        println(tail?.data)

    }

}

