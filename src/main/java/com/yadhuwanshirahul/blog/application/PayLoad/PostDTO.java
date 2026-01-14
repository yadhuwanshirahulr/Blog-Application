package com.yadhuwanshirahul.blog.application.PayLoad;

import java.time.LocalDateTime;

public class PostDTO {
    private String title;
    private String content;
    private String imageName;
    private CategoryDTO category;
    private UserDto user;
    private LocalDateTime addedDate;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
