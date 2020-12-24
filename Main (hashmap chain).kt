package com.company

import java.util.ArrayList

// A node of chains
internal class HashNode<K, V>     // Constructor
    (var key: K, var value: V) {
    // Reference to next node
    var next: HashNode<K, V>? = null
} // Class to represent entire hash table

internal class Map<K, V> {









    // bucketArray is used to store array of chains
    private var bucketArray: ArrayList<HashNode<K, V>?>

    // Current capacity of array list
    private var numBuckets: Int

    // Current size of array list
    private var size: Int
    fun size(): Int {
        return size
    }

    val isEmpty: Boolean
        get() = size() == 0

    // This implements hash function to find index
    // for a key
    private fun getBucketIndex(key: K): Int {
        val hashCode = key.hashCode()
        return hashCode % numBuckets
    }

    // Method to remove a given key
    fun remove(key: K): V? {
        // Apply hash function to find index for given key
        val bucketIndex = getBucketIndex(key)

        // Get head of chain
        var head = bucketArray[bucketIndex]

        // Search for key in its chain
        var prev: HashNode<K, V>? = null
        while (head != null) {
            // If Key found
            if (head.key == key) break

            // Else keep moving in chain
            prev = head
            head = head.next
        }

        // If key was not there
        if (head == null) return null

        // Reduce size
        size--

        // Remove key
        if (prev != null) prev.next = head.next else bucketArray[bucketIndex] = head.next
        return head.value
    }

    // Returns value for a key
    operator fun get(key: K): V? {
        // Find head of chain for given key
        val bucketIndex = getBucketIndex(key)
        var head = bucketArray[bucketIndex]

        // Search key in chain
        while (head != null) {
            if (head.key == key) return head.value
            head = head.next
        }

        // If key not found
        return null
    }

    // Adds a key value pair to hash
    fun add(key: K, value: V) {
        // Find head of chain for given key
        val bucketIndex = getBucketIndex(key)
        var head = bucketArray[bucketIndex]

        // Check if key is already present
        while (head != null) {
            if (head.key == key) {
                head.value = value
                return
            }
            head = head.next
        }

        // Insert key in chain
        size++
        head = bucketArray[bucketIndex]
        val newNode = HashNode(key, value)
        newNode.next = head
        bucketArray[bucketIndex] = newNode

        // If load factor goes beyond threshold, then
        // double hash table size
        if (1.0 * size / numBuckets >= 0.7) {
            val temp = bucketArray
            bucketArray = ArrayList()
            numBuckets = 2 * numBuckets
            size = 0
            for (i in 0 until numBuckets) bucketArray.add(null)
            for (headNode in temp) {

                var headNodeCPY=headNode

                while (headNodeCPY != null) {
                    add(headNode?.key!!, headNode.value)
                    headNodeCPY = headNodeCPY.next
                }
            }
        }
    }



    // Constructor (Initializes capacity, size and
    // empty chains.
    init {
        bucketArray = ArrayList()
        numBuckets = 10
        size = 0

        // Create empty chains
        for (i in 0 until numBuckets) bucketArray.add(null)
    }

    companion object {
        // Driver method to test Map class
        @JvmStatic
        fun main(args: Array<String>) {
            val map = Map<String, Int>()
            map.add("this", 1)
            map.add("coder", 2)
            map.add("this", 4)
            map.add("hi", 5)
            println(map.size())
            println(map.remove("this"))
            println(map.remove("this"))
            println(map.size())
            println(map.isEmpty)
        }
    }

}