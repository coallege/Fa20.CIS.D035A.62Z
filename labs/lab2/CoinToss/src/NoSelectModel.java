import javax.swing.DefaultListSelectionModel;

@SuppressWarnings("serial")
public class NoSelectModel extends DefaultListSelectionModel {
	@Override
	public void setAnchorSelectionIndex(int i) {}

	@Override
	public void setLeadAnchorNotificationEnabled(boolean b) {}

	@Override
	public void setLeadSelectionIndex(int i) {}

	@Override
	public void setSelectionInterval(int i, int ii) {}
}
