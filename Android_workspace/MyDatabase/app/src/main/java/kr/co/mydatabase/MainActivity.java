package kr.co.mydatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION = 1;

    // 생성자
    // factory : 커서를 지정하는 매개변수
    //           null로 전달하면 표준 커서가 사용됨.

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 데이터베이스가 처음 생성될때 호출됨
    // 테이블 생성 , 초기화
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE contacts (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "name TEXT, tel TEXT);");
    }

    // 데이터베이스가 업그레이드될 필요가 있을때 호출됨.
    // 기존 테이블 삭제하고 새로 만들어주면 됨.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sqLiteDatabase);
    }
}

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    SQLiteDatabase db;
    EditText edit_name, edit_tel;
    TextView edit_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DBHelper 객체 생성
        dbHelper = new DBHelper(this);

        try{
            // DB 필요할때 사용 (데이터베이스 연산 기능 제공-저장,삭제..)
            db = dbHelper.getWritableDatabase();

        }catch (SQLiteException ex){
            db = dbHelper.getReadableDatabase();
        }
        edit_name = findViewById(R.id.name);
        edit_tel = findViewById(R.id.tel);
        edit_result = findViewById(R.id.textView);
    }


    public void insert(View target){
        String name = edit_name.getText().toString();
        String tel = edit_tel.getText().toString();

        db.execSQL("INSERT INTO contacts VALUES (null,'"+name+"', '"+tel+"');");
        Toast.makeText(getApplicationContext(),"성공적으로 추가되었음",Toast.LENGTH_SHORT).show();

        edit_name.setText("");
        edit_tel.setText("");
    }
    public void selectAll(View target){
        // 쿼리의 결과가 커서로 반환됨.
        Cursor cursor = db.rawQuery("SELECT * FROM contacts",null);

        String str = "Id        Name        Tel \r\n";
        if(cursor !=null){
            // 커서를 첫번째 레코드로 이동함.
            while(cursor.moveToNext()){
                // 커서로부터 id, name, tel을 얻음.
                str += cursor.getString(0)+"        ";
                str += cursor.getString(1)+"        ";
                str += cursor.getString(2)+"        \r\n";
            }
        }

        edit_result.setText(str);
    }
    public void search(View target){
        String name = edit_name.getText().toString();
        Cursor cursor = db.rawQuery("SELECT name,tel FROM contacts WHERE name ='"+name+"';",null);

        Toast.makeText(getApplicationContext(), ""+cursor.getCount(),Toast.LENGTH_SHORT).show();
    }

}