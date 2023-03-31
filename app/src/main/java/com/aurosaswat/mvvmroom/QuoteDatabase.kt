package com.aurosaswat.mvvmroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun quoteDao(): QuoteDao

    /**
     *
     * In Android development, the companion object is used in Kotlin classes to define static methods and properties.

    In Kotlin, static methods and properties are defined using the companion object keyword. This allows them to be accessed without having to create an instance of the class.
    In Android development, the companion object is often used to define factory methods, which are used to create instances of a class with a specific configuration.
    For example, a factory method may create a new instance of a network client with default settings.

    Additionally, the companion object can be used to provide a singleton instance of a class. In this case, the companion object acts as a global instance of the class, which can be accessed from anywhere in the code.
    Overall, the companion object is a useful feature in Android development, as it allows developers to define static methods and properties in a concise and easy-to-use way.
     *
     * */

    companion object{
//        The below lines remains the same all the time
        private var INSTANCE: QuoteDatabase?=null
//        It will take the context as the argument and it will return The QuoteDatabase object ;0
        fun getDatabase(context: Context): QuoteDatabase {
//            Apply a simple Check if Instance is Null then create else return
            if(INSTANCE ==null){
//                we use of synchronize block becoz it is a multi threaded application ;)
                synchronized(this){
                    /**
                     * Theory on Synchronized - In Android development, the synchronized keyword and synchronized blocks are used to manage access to shared resources or critical sections of code that may be accessed by multiple threads concurrently.

                    When multiple threads attempt to access a shared resource or critical section of code at the same time, race conditions can occur, leading to unexpected behavior or crashes in the application. Synchronization helps to prevent these issues by ensuring that only one thread can access the shared resource or critical section of code at a time.

                    A synchronized block is a block of code that is enclosed in a synchronized statement. When a thread enters a synchronized block, it acquires a lock on the specified object or class, preventing other threads from entering the same block until the lock is released.

                    In Android, synchronized blocks are often used to manage access to UI elements, such as views or layouts, which can be accessed by multiple threads in response to user events or background tasks. They can also be used to ensure thread safety when accessing shared data structures or resources, such as databases or files.

                    However, it's worth noting that synchronized blocks can cause performance issues if used excessively or improperly, as they can lead to thread contention and blocking. Therefore, it's important to use synchronization judiciously and only where it is necessary to maintain thread safety.
                     * */
//                    Make Sure that the our whole application has only one context which can access the database ;) and pass the application context
                    INSTANCE = Room.databaseBuilder(context,
                    QuoteDatabase::class.java,
                    "quote_database").createFromAsset("quotes.db").build()
//                    In this way we create an instance of the Database ;)
//                    We use .createFromAsset to prepopulate data from a database ;)

                    return INSTANCE!!
                }
            }else{
                return INSTANCE!!
            }
        }

    }
}