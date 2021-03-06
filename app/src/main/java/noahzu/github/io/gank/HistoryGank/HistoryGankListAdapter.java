package noahzu.github.io.gank.HistoryGank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

import noahzu.github.io.gank.Common.PhotoActivity;
import noahzu.github.io.gank.Data.entity.HistoryGankResult;
import noahzu.github.io.gank.R;

/**
 * Created by Administrator on 2016/7/10.
 */
public class HistoryGankListAdapter extends BaseQuickAdapter<HistoryGankResult.PreviewGank>{


    public HistoryGankListAdapter(Context context, int layoutResId, List<HistoryGankResult.PreviewGank> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder,final HistoryGankResult.PreviewGank previewGank) {
        ImageView imageView = holder.getView(R.id.his_gank_img);
        Picasso.with(mContext).load(previewGank.getImageUrl()).into(imageView);
        holder.setText(R.id.his_gank_txt,previewGank.title);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PhotoActivity.class);
                intent.putExtra(PhotoActivity.IMAGE_URL,previewGank.getImageUrl());
                mContext.startActivity(intent);
            }
        });
    }

}
