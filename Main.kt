package com.company

import kotlin.jvm.JvmStatic
import com.company.LinearProbingHashTable
import java.util.*

/** Class LinearProbingHashTable  */
internal class LinearProbingHashTable(private val maxSize: Int) {
    /** Function to get size of hash table  */


    var size = 0

    private var keys: Array<String?>
    private var vals: Array<String?>

    /** Function to clear hash table  */
    fun makeEmpty() {
        size = 0
        keys = arrayOfNulls(maxSize)
        vals = arrayOfNulls(maxSize)
    }

    /** Function to check if hash table is full  */
    val isFull: Boolean
        get() = size == maxSize

    /** Function to check if hash table is empty  */
    val isEmpty: Boolean
        get() = size == 0

    /** Fucntion to check if hash table contains a key  */
    operator fun contains(key: String): Boolean {
        return get(key) != null
    }

    /** Functiont to get hash code of a given key  */
    private fun hash(key: String?): Int {
        return key.hashCode() % maxSize
    }

    /** Function to insert key-value pair  */
    fun insert(key: String?, `val`: String?) {
        val tmp = hash(key)
        var i = tmp

        do {
            if (keys[i] == null) {
                keys[i] = key
                vals[i] = `val`
                size++
                return
            }

            if (keys[i] == key) {
                vals[i] = `val`
                return
            }
            i = (i + 1) % maxSize
        } while (i != tmp)
    }

    /** Function to get value for a given key  */
    operator fun get(key: String): String? {
        var i = hash(key)
        while (keys[i] != null) {
            if (keys[i] == key) {
                return vals[i]
            }
            i = (i + 1) % maxSize
        }
        return null
    }


    /** Function to remove key and its value  */
    fun remove(key: String) {
        if (!contains(key)){
            return
        }
        /** find position key and delete  */
        var i = hash(key)
        while (key != keys[i]) {
            i = (i + 1) % maxSize
        }

        vals[i] = null
        keys[i] = vals[i]
        /** rehash all keys  */

        i = (i + 1) % maxSize


        while (keys[i] != null) {
            val tmp1 = keys[i]
            val tmp2 = vals[i]
            vals[i] = null
            keys[i] = vals[i]
            size--
            insert(tmp1, tmp2)
            i = (i + 1) % maxSize
        }
        size--
    }

    /** Function to print HashTable  */
    fun printHashTable() {
        println("\nHash Table: ")

        for (i in 0 until maxSize) {

            if (keys[i] != null) {

                println(keys[i].toString() + " " + vals[i])
            }
        }

        println()
    }

    /** Constructor  */
    init {
        keys = arrayOfNulls(maxSize)
        vals = arrayOfNulls(maxSize)
    }
}

/** Class LinearProbingHashTableTest  */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val scan = Scanner(System.`in`)
        println("Hash Table Test\n\n")
        println("Enter size")
        /** maxSizeake object of LinearProbingHashTable  */
        val lpht = LinearProbingHashTable(scan.nextInt())
        var ch: Char
        /**  Perform LinearProbingHashTable operations   */
        do {
            println("\nHash Table Operations\n")
            println("1. insert ")
            println("2. remove")
            println("3. get")
            println("4. clear")
            println("5. size")
            val choice = scan.nextInt()
            when (choice) {
                1 -> {
                    println("Enter key and value")
                    lpht.insert(scan.next(), scan.next())
                }
                2 -> {
                    println("Enter key")
                    lpht.remove(scan.next())
                }
                3 -> {
                    println("Enter key")
                    println("Value = " + lpht[scan.next()])
                }
                4 -> {
                    lpht.makeEmpty()
                    println("Hash Table Cleared\n")
                }
                5 -> println("Size = " + lpht.size)
                else -> println("Wrong Entry \n ")
            }
            /** Display hash table  */
            lpht.printHashTable()
            println("\nDo you want to continue (Type y or n) \n")
            ch = scan.next()[0]
        } while (ch == 'Y' || ch == 'y')
    }
}