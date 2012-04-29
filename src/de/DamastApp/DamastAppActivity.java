package de.DamastApp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class DamastAppActivity extends Activity {

	@Override
	public void onCreate(Bundle icicle) {

		super.onCreate(icicle);
		setContentView(R.layout.main);
		Gallery gallery = (Gallery)
		findViewById(R.id.gallery);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setOnItemClickListener(new OnItemClickListener()
		{

			public void onItemClick(AdapterView parent,
			View v,
			int position,
			long id)

			{

				Toast.makeText(DamastAppActivity.this, "" + position,
				Toast.LENGTH_SHORT).show();
			}

		});

	}

	public class ImageAdapter extends BaseAdapter
	{

		public ImageAdapter(Context c)
		{
			mContext = c;
		}

		public int getCount()
		{
			return mImageIds.length;
		}

		public Object getItem(int position)
		{
			return position;
		}

		public long getItemId(int position)
		{
			return position;
		}

		public View getView(int position, View
		convertView, ViewGroup parent)
		{
			ImageView i = new ImageView(mContext);
			i.setImageResource(mImageIds[position]);
			i.setScaleType(ImageView.ScaleType.FIT_XY);
			i.setLayoutParams(new Gallery.LayoutParams(160, 200));
			return i;
		}

		public float getAlpha(boolean focused, int offset)
		{
			return Math.max(0, 1.0f - (0.2f * Math.abs(offset)));
		}

		public float getScale(boolean focused, int offset)
		{
			return Math.max(0, 1.0f - (0.2f *
			Math.abs(offset)));
		}
		private Context mContext;
		private Integer[] mImageIds = {
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher,
		R.drawable.ic_launcher
		};

	}

}