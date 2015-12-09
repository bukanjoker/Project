package example.dmesenv1_2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
 
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.asem, R.drawable.ayam,
            R.drawable.bakso, R.drawable.kangkung,
            R.drawable.mie, R.drawable.mie_,
            R.drawable.nasgor, R.drawable.pempek,
            R.drawable.sop, R.drawable.soto,
            R.drawable.cendol, R.drawable.kelapa,
            R.drawable.kopi, R.drawable.teh
    };
 
    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }
 
    @Override
    public int getCount() {
        return mThumbIds.length;
    }
 
    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }
 
}