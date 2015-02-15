package chuang.lrucachedemo.android.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import chuang.lrucachedemo.R;
import chuang.lrucachedemo.bean.Images;
import chuang.lrucachedemo.widget.util.ImageLoader;

/**
 * Created by N-251 on 2015/2/15.
 */
public class ImgsListFragment extends Fragment {
    private GridView mGridView;
    private String[] mUrlStrs = Images.imageThumbUrls;
    private ImageLoader mImageLoader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageLoader = ImageLoader.getInstance(3, ImageLoader.Type.LIFO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_imgs_list, container, false);
        mGridView = (GridView) contentView.findViewById(R.id.gridview);
        setUpAdapter();
        return contentView;
    }

    private void setUpAdapter() {
        if (getActivity() == null || mGridView == null)
            return;

        if (mUrlStrs != null) {
            mGridView.setAdapter(new ListImgItemAdaper(getActivity(), 0, mUrlStrs));
        } else {
            mGridView.setAdapter(null);
        }
    }

    private class ListImgItemAdaper extends ArrayAdapter<String> {

        public ListImgItemAdaper(Context context, int resource, String[] datas) {
            super(getActivity(), 0, datas);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.item_imgs_list, parent, false);
            }
            ImageView imageview = (ImageView) convertView.findViewById(R.id.id_img);
            imageview.setImageResource(R.drawable.pictures_no);
            mImageLoader.loadImage(getItem(position), imageview, true);
            return convertView;
        }
    }
}
