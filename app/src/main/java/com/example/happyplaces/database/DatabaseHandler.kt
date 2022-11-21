package com.example.happyplaces.database
import android.annotation.SuppressLint
import com.example.happyplaces.models.HappyPlaceModel
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHandler(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "HappyPlacesDatabase"
        private val TABLE_HAPPY_PLACE = "HappyPlacesTable"

        //All the Columns names
        private val KEY_ID = "id"
        private val KEY_TITLE = "title"
        private val KEY_IMAGE = "image"
        private val KEY_DESCRIPTION = "description"
        private val KEY_DATE = "date"
        private val KEY_LOCATION = "location"
        private val KEY_LATITUDE = "latitude"
        private val KEY_LONGITUDE = "longitude"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PLACES_TABLE = ("CREATE TABLE " + TABLE_HAPPY_PLACE +"("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT,"
                + KEY_IMAGE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_DATE + " TEXT,"
                + KEY_LOCATION + " TEXT,"
                + KEY_LATITUDE + " TEXT,"
                + KEY_LONGITUDE + " TEXT)")
        db?.execSQL(CREATE_PLACES_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_HAPPY_PLACE")
        onCreate(db)
    }

    fun addHappyPlace(happyPlace: HappyPlaceModel):Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_TITLE , happyPlace.title)
        contentValues.put(KEY_IMAGE , happyPlace.image)
        contentValues.put(KEY_DESCRIPTION , happyPlace.description)
        contentValues.put(KEY_DATE , happyPlace.date)
        contentValues.put(KEY_LOCATION , happyPlace.location)
        contentValues.put(KEY_LATITUDE , happyPlace.latitude)
        contentValues.put(KEY_LONGITUDE , happyPlace.longitude)
        Log.e("contentValues","$contentValues")
        val result = db.insert(TABLE_HAPPY_PLACE,null,contentValues)
        db.close()
        return result
    }

    @SuppressLint("Range")
    fun getHappyPlacesList():List<HappyPlaceModel>{
        val happyPlaceList = ArrayList<HappyPlaceModel>()
        val selectQuery = "SELECT  * FROM $TABLE_HAPPY_PLACE"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
            var title: String
            var image: String
            if (cursor.moveToFirst()) {
                do {
                    val place = HappyPlaceModel(
                        cursor.getInt(cursor.getColumnIndex(KEY_ID)),
                        cursor.getString(cursor.getColumnIndex(KEY_TITLE)),
                        cursor.getString(cursor.getColumnIndex(KEY_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(KEY_DATE)),
                        cursor.getString(cursor.getColumnIndex(KEY_LOCATION)),
                        cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE)),
                        cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDE))
                    )

                    happyPlaceList.add(place)
                } while (cursor.moveToNext())
            }
            cursor.close()
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        return happyPlaceList
    }
}