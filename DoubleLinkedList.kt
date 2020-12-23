class DoubleLinkedList<T>:SinglyLinkedList<T>(){




        fun append(data:T){

            var newNode=Node(data,null,tail)

            if (head==null){
                head=newNode
            }
            else{
                tail?.next=newNode
            }
            tail=newNode
        }




        fun DeleteTail(){

            if(head==null){
                return
            }

            tail=tail?.previous

            if(tail==null){
                head=null
            }


        }




        fun printBackwards(){


            var node = tail

            while(node!=head){


                println(node?.data)

                node=node?.previous
            }

            println(head?.data)

        }





    }




