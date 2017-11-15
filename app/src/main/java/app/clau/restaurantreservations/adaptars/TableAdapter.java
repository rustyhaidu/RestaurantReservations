package app.clau.restaurantreservations.adaptars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.clau.restaurantreservations.R;
import app.clau.restaurantreservations.models.BaseTable;

/**
 * Created by Claudiu on 13-Nov-17.
 */

public class TableAdapter extends BaseAdapter {

    private Context mContext;
    private List<BaseTable> mTableList;

    public TableAdapter(Context context, List<BaseTable> tableList){
        mContext = context;
        mTableList = tableList;
    }

    @Override
    public int getCount() {
        return mTableList.size();
    }

    @Override
    public Object getItem(int i) {
        return mTableList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0; // we aren't going to use this. Tag Items for ezasy reference
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.table_list_item_view, null);
            holder = new ViewHolder();

            holder.tvTableNumber = convertView.findViewById(R.id.textNumber);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        BaseTable currentTable = mTableList.get(position);
        int number = currentTable.getNumber();
        holder.tvTableNumber.setText(number+"");

        return convertView;
    }

    private static class ViewHolder {
        TextView tvTableNumber;
    }
}
