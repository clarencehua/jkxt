package software.lawyer.service.model.base;

import java.util.ArrayList;
import java.util.List;

public class JsTreeModel implements Comparable<JsTreeModel> {

	private String id;
	private String text;
	private State state = new State();
	// js的图标,支持font-awesome
	private String icon;
	private int xsxs;
	private List<JsTreeModel> children=new ArrayList<JsTreeModel>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public State getState() {
		return state;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getXsxs() {
		return xsxs;
	}

	public void setXsxs(int xsxs) {
		this.xsxs = xsxs;
	}

	public List<JsTreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<JsTreeModel> children) {
		this.children = children;
	}

	public void setState(boolean selected, boolean opened, boolean diabled) {
		this.state.selected = selected;
		this.state.opened = opened;
		this.state.disabled = diabled;
	}

	public void setSelected(boolean selected) {
		this.state.selected = selected;
	}

	@Override
	public String toString() {
		return "JsTreeModel [id=" + id + ", text=" + text + ", state=" + state + ", icon=" + icon + ", xsxs=" + xsxs
				+ ", children=" + children + "]";
	}

	public int compareTo(JsTreeModel o) {
		if (this.xsxs > o.getXsxs()) {
			return 1;
		} else if (this.xsxs < o.getXsxs()) {
			return -1;
		}
		return 0;
	}

	// tree状态，包括是否选择，是否打开,是否可用,默认都是false
	class State {

		private boolean selected = false;
		private boolean opened = false;
		private boolean disabled = false;

		public boolean isSelected() {
			return selected;
		}

		public void setSelected(boolean selected) {
			this.selected = selected;
		}

		public boolean isOpened() {
			return opened;
		}

		public void setOpened(boolean opened) {
			this.opened = opened;
		}

		public boolean isDisabled() {
			return disabled;
		}

		public void setDisabled(boolean disabled) {
			this.disabled = disabled;
		}

		@Override
		public String toString() {
			return "State [selected=" + selected + ", opened=" + opened + ", disabled=" + disabled + "]";
		}

	}

}
