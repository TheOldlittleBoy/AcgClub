package com.rabtman.acgclub.mvp.ui.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rabtman.acgclub.R;
import com.rabtman.acgclub.mvp.model.jsoup.APic.PicInfo;
import com.rabtman.common.imageloader.ImageLoader;
import com.rabtman.common.imageloader.glide.GlideImageConfig;

/**
 * @author Rabtman
 */

public class AcgPicItemAdapter extends BaseQuickAdapter<PicInfo, BaseViewHolder> {

  private ImageLoader mImageLoader;

  public AcgPicItemAdapter(ImageLoader imageLoader) {
    super(R.layout.item_pic_item, null);
    mImageLoader = imageLoader;
  }


  @Override
  protected void convert(BaseViewHolder helper, PicInfo item) {
    helper.setText(R.id.pic_title, item.getTitle())
        .setText(R.id.pic_date, item.getDate())
        .setText(R.id.pic_count, item.getCount());
    mImageLoader.loadImage(mContext,
        GlideImageConfig
            .builder()
            .url(item.getThumbUrl())
            .zoomStrategy(GlideImageConfig.FIT_CENTER)
            .imagerView((ImageView) helper.getView(R.id.pic_img))
            .build()
    );
  }
}
