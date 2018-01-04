package com.example.user.android_assignment_8_3;
//Package objects contain version information about the implementation and specification of a Java package.
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;



public class MainActivity extends AppCompatActivity {
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with AppCompatActivity which is Parent class.
    GridView gridView;

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adp=new MyAdapter(MainActivity.this);
        //creating myadapter objecct
        gridView=(GridView)findViewById(R.id.grid);
        gridView.setAdapter((ListAdapter) adp);
        //Sets the data behind this ListView.
    }
}
