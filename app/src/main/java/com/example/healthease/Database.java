package com.example.healthease;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public String ans = new String();
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
//    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
    }

    private static Database instance;

    private static final String DATABASE_NAME = "healthcare";
    private static final int DATABASE_VERSION = 1;

    private Database(@Nullable Context context,@Nullable SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    public static synchronized Database getInstance(Context context, SQLiteDatabase.CursorFactory factory) {
        if (instance == null) {
            instance = new Database(context.getApplicationContext(), factory);
            instance.getWritableDatabase();
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1=" create table users(username text, email text, password text)";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "create table cart(username text, product text, price float, otype text)";
        sqLiteDatabase.execSQL(qry2);

        String qry3 = "create table orderplace(username text, fullname text, address text, contactno text, pincode int, date text, time text, amount float, otype text)";
        sqLiteDatabase.execSQL(qry3);

        String qry4 = "create table appointment(username text, fullname text, address text, contactno text, date text, time text, amount float, otype text)";
        sqLiteDatabase.execSQL(qry4);

        String qry5 = "create table totalDepartmentWiseAppointment(name text, total int)";
        sqLiteDatabase.execSQL(qry5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username, String email, String password){
        ContentValues cv= new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db= getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }


    public int login(String username, String password){
        int result=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db= getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where username=? and password=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        return result;
    }

    public void addCart(String username, String product, float price, String otype) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product", product);
        cv.put("price", price);
        cv.put("otype", otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart",  null, cv);
        db.close();
    }

    public int checkCart(String username, String product) {
        int result = 0;
        String[] str = new String[2];
        str[0] = username;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from cart where username = ? and product = ?", str);
        if(c.moveToFirst()) {
            result = 1;
        }
        db.close();
        return result;
    }

    public void removeCart(String username, String otype) {
        String[] str = new String[2];
        str[0] = username;
        str[1] = otype;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart",  "username=? and otype=?",  str);
        db.close();
    }

    public ArrayList getCartData(String username, String otype)
    {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[2];
        str[0] = username;
        str[1] = otype;
        Cursor c = db.rawQuery("select * from cart where username = ? and otype = ?", str);
        if(c.moveToFirst()){
            do{
                String product = c.getString(1);
                String price = c.getString(2);
                arr.add(product+"Taka "+price);
            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }

    public void addOrder(String username, String fullname, String address, String contact, int pincode, String date, String time, float price, String otype  )
    {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("fullname", fullname);
        cv.put("address", address);
        cv.put("contactno", contact);
        cv.put("pincode", pincode);
        cv.put("date", date);
        cv.put("time", time);
        cv.put("amount", price);
        cv.put("otype", otype);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("orderPlace", null, cv);
        db.close();

    }

    public ArrayList getOrderData(String username){
        ArrayList<String> arr =new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String str[]=new String[1];
        str[0]=username;
        Cursor c=db.rawQuery("select * from orderplace where username=?",str);
        if(c.moveToFirst()){
            do {
                arr.add(c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getString(4)+"$"+c.getString(5)+"$"+c.getString(6)+"$"+c.getString(7)+"$"+c.getString(8));
            }while(c.moveToNext());

        }
        db.close();
        return arr;

    }

    public void addAppointment(String username, String docname, String address, String contact,  String date, String time, float price, String otype  )
    {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("fullname", docname);
        cv.put("address", address);
        cv.put("contactno", contact);
        cv.put("date", date);
        cv.put("time", time);
        cv.put("amount", String.valueOf(price));
        cv.put("otype", otype);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("appointment", null, cv);
        db.close();

    }

    public int checkAppointmentExists(String username, String fullname, String address, String contact, String date, String time)
    {
        int result = 0;
        String str[] = new String[3];
        str[0] = username ;
        str[1] = fullname;
        str[2] = date;
        //  str[2] = address;
        //  str[3] = contact;
        //  str[4] = date;
        //  str[5] = time;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from orderplace where username = ? and fullname = ? and date = ?", str);
        //  String qry3 = "create table orderplace(username text, fullname text, address text, contactno text, pincode int, date text, time text, amount float, otype text)";

        if(c.moveToFirst())
        {
            result=1;
        }
        db.close();
        return result;

    }

//    public void updateTotalAppointment(String name, Integer total) {
//        ContentValues cv = new ContentValues();
//        cv.put("name", name);
//        cv.put("total", total);
//        SQLiteDatabase db = getWritableDatabase();
//        db.insert("totalDepartmentWiseAppointment",  null, cv);
//        db.close();
//    }

    public void updateTotalAppointment(String name, Integer total) {

        SQLiteDatabase db=getWritableDatabase();
        String str[]=new String[1];
        str[0]=name;
        Cursor c=db.rawQuery("select * from totalDepartmentWiseAppointment where name=?",str);
        if(c.getCount()==0)
        {
            ContentValues cv = new ContentValues();
            cv.put("name", name);
            cv.put("total", total);


            //SQLiteDatabase db = getWritableDatabase();
            db.insert("totalDepartmentWiseAppointment", null, cv);
        }
        else
        {
            String strr[]=new String[2];
            strr[1]=name;
            strr[0]=String.valueOf(total);
            db.execSQL("UPDATE totalDepartmentWiseAppointment SET total = ? WHERE name = ?", strr);
        }




        db.close();
    }


    public String getTotal(String name){
        SQLiteDatabase db=getReadableDatabase();
        String str[]=new String[1];
        str[0]=name;
        int result;
        Cursor c=db.rawQuery("select * from totalDepartmentWiseAppointment where name=?",str);
        if(c.getCount()==0)
        {

        }
        if(c.moveToFirst()){
            result = c.getInt(1);
        }
        else
        {
            result = 0;
        }
        db.close();
        return String.valueOf(result);

    }








}