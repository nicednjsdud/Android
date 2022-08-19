package kr.co.singergroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    SQLiteDatabase db;
    EditText edit_name, edit_count;
    TextView edit_result_name, edit_result_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.lena);
        setTitle("가수 그룹 관리 앱");

        dbHelper = new DBHelper(this);

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }
        edit_name = findViewById(R.id.name);
        edit_count = findViewById(R.id.count);
        edit_result_name = findViewById(R.id.resultView1);
        edit_result_count = findViewById(R.id.resultView2);

    }

    public void init(View target){
        db.execSQL("DELETE FROM singerGroup");
        edit_result_name.setText("");
        edit_result_count.setText("");
        edit_name.setText("");
        edit_count.setText("");
        dbHelper = new DBHelper(this);
        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public void insert(View target){
        String name = edit_name.getText().toString();
        String count = edit_count.getText().toString();

        db.execSQL("INSERT INTO singerGroup VALUES (null,'"+name+"', '"+count+"');");
        edit_name.setText("");
        edit_count.setText("");
    }
    public void modify(View target){
        String name = edit_name.getText().toString();
        String _count = edit_count.getText().toString();


        Cursor cursor= db.rawQuery("SELECT name,count FROM singerGroup WHERE name ='"+name+"';",null);
        if(cursor !=null){
            db.execSQL("UPDATE singerGroup SET count='"+_count+"'WHERE name='"+name+"';");
        }
        else{
            Toast.makeText(this, "입력하신 정보가 없습니다.", Toast.LENGTH_SHORT).show();
        }

        dbHelper = new DBHelper(this);
        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }
        edit_result_name.setText("");
        edit_result_count.setText("");
        edit_name.setText("");
        edit_count.setText("");
    }
    public void delete(View target){
        String name = edit_name.getText().toString();
        String count = edit_count.getText().toString();
        Cursor cursor= db.rawQuery("SELECT name,count FROM singerGroup WHERE name ='"+name+"';",null);
        if(cursor !=null){
            db.delete("singerGroup","name =?",new  String[] {name});
        }
        else{
            Toast.makeText(this, "입력하신 정보가 없습니다.", Toast.LENGTH_SHORT).show();
        }
        edit_result_name.setText("");
        edit_result_count.setText("");
        edit_name.setText("");
        edit_count.setText("");
    }
    public void selectAll(View target){
        String str = "  그룹이름     \r\n--------------------\n";
        String str2 = "  인원     \r\n--------------------\n";
        edit_result_name.setText("");
        edit_result_count.setText("");
        Cursor cursor = db.rawQuery("SELECT * FROM singerGroup",null);
        if(cursor !=null){
            while(cursor.moveToNext()){
                str +=" "+ cursor.getString(1)+" \r\n";
                str2 +=" "+ cursor.getString(2)+" \r\n";
            }
        }

        edit_result_name.setText(str);
        edit_result_count.setText(str2);
    }
}