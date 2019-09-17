package com.bksx.nettest.adapter;



import androidx.annotation.Nullable;
import com.bksx.nettest.R;
import com.bksx.nettest.bean.Unit;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;


public class UnitAdapter extends BaseQuickAdapter<Unit,BaseViewHolder> {

    public UnitAdapter(int layoutResId, @Nullable List<Unit> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Unit item) {
        helper.setText(R.id.tv_unit, item.getUnitNum());
        if (item.isClick()){
            helper.setBackgroundRes(R.id.tv_unit, R.drawable.bg_unit_blue);
        }else {
            helper.setBackgroundRes(R.id.tv_unit, R.drawable.bg_unit_gray);
        }
    }


}
