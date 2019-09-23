package cos.mos.listwholesliding;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @Description:
 * @Author: Kosmos
 * @Date: 2019.09.23 20:46
 * @Email: KosmoSakura@gmail.com
 */
public class IAmAdapter extends BaseAdapter {
    private int[] arr;
    private Context context;

    IAmAdapter(Context context, int... arr) {
        this.arr = arr;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arr.length;
    }


    @Override
    public Integer getItem(int position) {
        return arr[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.iamitem, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        switch (position % 3) {
            case 0:
                holder.tName.setTextColor(Color.parseColor("#0BC5C5"));
                break;
            case 1:
                holder.tName.setTextColor(Color.parseColor("#2308B6"));
                break;
            case 2:
                holder.tName.setTextColor(Color.parseColor("#18DD39"));
                break;
        }
        holder.tName.setText("假如我这个地址的id是：" + arr[position]);
        return view;
    }

    private class ViewHolder {
        final TextView tName;

        ViewHolder(View root) {
            tName = root.findViewById(R.id.iamid);
        }
    }
}
