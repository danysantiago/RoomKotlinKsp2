package dany.test

import kotlin.test.Test

class RoomDatabaseTest {

    @Test
    fun testDatabase() {
        val db = createDatabase()
        db.close()
    }
}