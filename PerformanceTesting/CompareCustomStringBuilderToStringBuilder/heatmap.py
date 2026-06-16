import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# 1. Ingest standard performance data blocks
sb_df = pd.read_csv('StringBuilder_performance.csv', sep=';')
csb_df = pd.read_csv('CustomStringBuilder_performance.csv', sep=';')

# 2. Clean quotation marks from column headers
sb_df.columns = [c.replace('"', '') for c in sb_df.columns]
csb_df.columns = [c.replace('"', '') for c in csb_df.columns]

common_sizes = sorted(list(set(sb_df['Size']).intersection(set(csb_df['Size']))))

# 3. Compile list of tracking rows
methods_list = []
for c in sb_df.columns:
    if c != 'Size':
        methods_list.append(c)

heatmap_data = np.zeros((len(methods_list), len(common_sizes)))
text_labels = []

# 4. Generate delta factors with base-2 logarithms
for i, m in enumerate(methods_list):
    row_labels = []
    sb_col = m
    csb_col = m if m != 'StringBuilder(CharSequence)' else 'CustomStringBuilder(CharSequence)'

    for j, size in enumerate(common_sizes):
        sb_val = sb_df.loc[sb_df['Size'] == size, sb_col].values[0]
        csb_val = csb_df.loc[csb_df['Size'] == size, csb_col].values[0]

        if sb_val == 0: sb_val = 1
        if csb_val == 0: csb_val = 1

        ratio = np.log2(sb_val / csb_val)
        heatmap_data[i, j] = ratio

        # Display large factors neatly without decimal overflow
        if sb_val >= csb_val:
            factor = sb_val / csb_val
            row_labels.append(f"+{factor:.1f}x" if factor < 100 else f"+{factor:.0f}x")
        else:
            factor = csb_val / sb_val
            row_labels.append(f"-{factor:.1f}x" if factor < 100 else f"-{factor:.0f}x")
    text_labels.append(row_labels)

text_labels = np.array(text_labels)

# 5. Sort rows relative to average runtime delta trends
avg_ratios = np.mean(heatmap_data, axis=1)
sorted_idx = np.argsort(avg_ratios)

heatmap_data = heatmap_data[sorted_idx]
text_labels = text_labels[sorted_idx]
sorted_methods = [methods_list[idx] for idx in sorted_idx]

# Map constructors gracefully into clean label names
display_methods = [
    "Constructor(CharSequence)" if m == "StringBuilder(CharSequence)" else m
    for m in sorted_methods
]

# 6. Initialize extended figure size layout canvas to map 37 distinct rows safely
fig, ax = plt.subplots(figsize=(18, 22), facecolor='none')
ax.set_facecolor('none')

# Clip color bounds symmetrically at 16x variation thresholds
clipped_data = np.clip(heatmap_data, -4.0, 4.0)
cmap = sns.diverging_palette(15, 240, as_cmap=True)

# 7. Plot Heatmap Matrix
sns.heatmap(clipped_data,
            annot=text_labels,
            fmt="",
            cmap=cmap,
            center=0,
            xticklabels=common_sizes,
            yticklabels=display_methods,
            ax=ax,
            cbar_kws={
                'label': '← JDK Faster (StringBuilder)  |  Relative Speedup Scale (Clipped at 16x)  |  Custom Faster (CustomStringBuilder) →',
                'pad': 0.02},
            linewidths=0.5,
            linecolor='#444444',
            annot_kws={'size': 9, 'weight': 'bold'})

# 8. Typography styling setup
ax.set_title(
    'Java StringBuilder Performance Speedup Matrix Heatmap Across Sizes\n(Positive/Blue = CustomStringBuilder Faster, Negative/Red = StringBuilder Faster)',
    color='#ffffff', fontsize=18, fontweight='bold', pad=25)
ax.set_ylabel('StringBuilder Interface Methods', color='#aaaaaa', fontsize=14, labelpad=15)
ax.set_xlabel('String Content Size Bound (Length/Capacity)', color='#aaaaaa', fontsize=14, labelpad=15)

ax.tick_params(colors='#ffffff', labelsize=11)
plt.xticks(rotation=45)
plt.yticks(rotation=0)

cbar = ax.collections[0].colorbar
cbar.ax.tick_params(colors='#ffffff', labelsize=11)
cbar.ax.yaxis.label.set_color('#ffffff')
cbar.ax.yaxis.label.set_fontsize(13)

plt.tight_layout()
plt.savefig('string_builder_performance_heatmap.png', dpi=300, transparent=True)
plt.close()