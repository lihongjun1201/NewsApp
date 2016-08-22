package com.newtalent.allenlee.newsapp.main.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.newtalent.allenlee.newsapp.R;

/**
 * Created by AllenLee on 2016/8/22.
 */
public class MenuFragment extends ListFragment implements AdapterView.OnItemClickListener {

    /**
     * 侧拉menu-新闻大分类
     */
    private String[] newsCategorys;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflater.inflate(R.layout.list_menufragment, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //从string-array 中获取资源 （便于更改不同语言设置）
        newsCategorys = getResources().getStringArray(R.array.menu);

        setListAdapter(new MyMenuListAdapter());
        getListView().setOnItemClickListener(this);
    }

    private class MyMenuListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return newsCategorys.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout itemView = (LinearLayout) getActivity().getLayoutInflater().
                            inflate(R.layout.item_menufragment, null);
           TextView title = (TextView) itemView.findViewById(R.id.tv_menu_title);
            title.setText(newsCategorys[position]);
            return itemView;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

}
