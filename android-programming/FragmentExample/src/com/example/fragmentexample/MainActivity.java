package com.example.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {

	FragmentManager fm = getSupportFragmentManager();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if(savedInstanceState == null){
        	Fragment1 f = new Fragment1();
        	FragmentTransaction ft = fm.beginTransaction();
        	ft.add(R.id.right_layout, f, "fragment");
        	ft.commit();
        }
        
        String [] lista = new String[]{"Usuário", "Empresa"};
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        
        ListView listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter(aa);
    
        listView.setOnItemClickListener(new OnItemClickListener() {
			
        	@Override
			public void onItemClick(AdapterView<?> lv, View view, int position, long id) {
			
        		FragmentTransaction ft = fm.beginTransaction();
				
        		if(position == 0){
					Fragment1 f1 = new Fragment1();
					ft.replace(R.id.right_layout, f1, "fragment");
				
				}else if(position == 1){
					Fragment2 f2 = new Fragment2();
					ft.replace(R.id.right_layout, f2, "fragment");
				}
        		
				ft.addToBackStack("pilha");
				
				ft.commit();
			}
		});
    }
}	
