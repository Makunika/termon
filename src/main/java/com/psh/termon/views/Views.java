package com.psh.termon.views;

public class Views {
    public interface Id {}
    public interface IdName extends Id {}
    public interface MainInformation extends IdName {}

    public interface CourseModules extends MainInformation {}

    public interface ModuleLessons extends MainInformation {}

    public interface FullCourse extends MainInformation {}

    public interface FullModule extends MainInformation {}

    public interface FullLesson extends MainInformation {}

}
