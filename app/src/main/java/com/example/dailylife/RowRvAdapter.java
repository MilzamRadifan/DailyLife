package com.example.dailylife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RowRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private List<RowRv> rutinitas;

  public RowRvAdapter(List<RowRv> rutinitas) {
    this.rutinitas = rutinitas;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rv, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    RowRv rv = rutinitas.get(position);
    ViewHolder vh = (ViewHolder) holder;

    vh.tvName.setText(rv.getName());
    vh.tvActivity.setText(rv.getActivity());
    vh.tvTime.setText(rv.getActivity());
  }

  @Override
  public int getItemCount() {
    return rutinitas.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView tvName,tvActivity,tvTime;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      tvName = itemView.findViewById(R.id.tvName);
      tvActivity = itemView.findViewById(R.id.tvActivity);
      tvTime = itemView.findViewById(R.id.tvTime);
    }
  }
}
