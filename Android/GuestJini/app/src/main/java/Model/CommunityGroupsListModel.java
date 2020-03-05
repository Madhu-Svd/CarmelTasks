package Model;

import java.io.Serializable;

public class CommunityGroupsListModel implements Serializable {
    int addNotificationIndicator;
    String addCommunityGroupTitle;
    String addAdminProfileIcon;
    String addCommunityGroupAdminName;
    String addCommunityGroupCreationDateAndTime;
    String addCommunityGroupDescription;
    String addCommunityGroupInformationMessage;
    int addInformationIcon;



    public int getAddNotificationIndicator() {
        return addNotificationIndicator;
    }

    public void setAddNotificationIndicator(int addNotificationIndicator) {
        this.addNotificationIndicator = addNotificationIndicator;
    }

    public String getAddCommunityGroupTitle() {
        return addCommunityGroupTitle;
    }

    public void setAddCommunityGroupTitle(String addCommunityGroupTitle) {
        this.addCommunityGroupTitle = addCommunityGroupTitle;
    }

    public String getAddAdminProfileIcon() {
        return addAdminProfileIcon;
    }

    public void setAddAdminProfileIcon(String addAdminProfileIcon) {
        this.addAdminProfileIcon = addAdminProfileIcon;
    }

    public String getAddCommunityGroupAdminName() {
        return addCommunityGroupAdminName;
    }

    public void setAddCommunityGroupAdminName(String addCommunityGroupAdminName) {
        this.addCommunityGroupAdminName = addCommunityGroupAdminName;
    }
    public String getAddCommunityGroupCreationDateAndTime() {
        return addCommunityGroupCreationDateAndTime;
    }

    public void setAddCommunityGroupCreationDateAndTime(String addCommunityGroupCreationDateAndTime) {
        this.addCommunityGroupCreationDateAndTime = addCommunityGroupCreationDateAndTime;
    }

    public String getAddCommunityGroupDescription() {
        return addCommunityGroupDescription;
    }

    public void setAddCommunityGroupDescription(String addCommunityGroupDescription) {
        this.addCommunityGroupDescription = addCommunityGroupDescription;
    }

    public String getAddCommunityGroupInformationMessage() {
        return addCommunityGroupInformationMessage;
    }

    public void setAddCommunityGroupInformationMessage(String addCommunityGroupInformationMessage) {
        this.addCommunityGroupInformationMessage = addCommunityGroupInformationMessage;
    }

    public int getAddInformationIcon() {
        return addInformationIcon;
    }

    public void setAddInformationIcon(int addInformationIcon) {
        this.addInformationIcon = addInformationIcon;
    }
}
