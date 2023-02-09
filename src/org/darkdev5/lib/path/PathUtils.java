package org.darkdev5.lib.path;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Arrays;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public @Getter
@Setter class PathUtils {
    /**
     * Check the path to see if it exists on the device or not.
     */
    private boolean pathCheckEnable;

    /**
     * This String will be use if system can't find the path on the device.
     */
    private String invalidPathReplacement;

    public PathUtils(String invalidPathReplacement, boolean pathExists) {
        this.invalidPathReplacement = invalidPathReplacement;
        this.pathCheckEnable = pathExists;
    }

    /**
     * Method for simplify returning the paths.
     *
     * @param checkPath The method will check this path to see if it exists on the device or not.
     * @param validPath The main path that must return when all values are true.
     * @return Check the paths and returns the true path.
     */
    private String returnPath(String checkPath, String validPath) {
        if (pathCheckEnable && !new File(checkPath).exists()) {
            return invalidPathReplacement;
        }

        return validPath;
    }

    /**
     * Get the file or folder full path on device from its name.
     *
     * @param name The name of file or folder.
     * @return The full path of that file or folder on the device.
     */
    public String getPath(String name) {
        return returnPath(name,
                new File(name).getAbsolutePath());
    }

    /**
     * Get the file or folder name from its full path.
     *
     * @param path The full path of file or folder on the device.
     * @return The full name of file or folder.
     */
    public String getName(String path) {
        return returnPath(path,
                new File(path).getName());
    }

    /**
     * The base name is part of file name that doesn't have extension.
     * Folders don't have base name or any extension so this method will return only it's name.
     *
     * @param path The full path of file or folder on the device.
     * @return The base name of the file or folder.
     */
    public String getBaseName(String path) {
        return returnPath(path,
                FilenameUtils.getBaseName(path));
    }

    /**
     * Get the extension of any file.
     * If it doesn't have extension it will return nothing.
     * Folders don't have extension.
     *
     * @param path The full path of file or folder on the device.
     * @return The extension of file or folder.
     */
    public String getExtension(String path) {
        return returnPath(path,
                FilenameUtils.getExtension(path));
    }

    /**
     * The parent means the folder that this file or folder is in it.
     *
     * @param path The full path of file or folder on the device.
     * @return The parent name of the file or folder.
     */
    public String getParentName(String path) {
        if (Arrays.asList(File.listRoots()).contains(new File(path))) {
            return path;
        }

        return returnPath(path,
                FilenameUtils.getName(new File(path).getAbsoluteFile().getParentFile().getAbsolutePath()));
    }

    /**
     * The parent means the folder that this file or folder is in it.
     *
     * @param path The full path of file or folder on the device.
     * @return The parent path of the file or folder.
     */
    public String getParentPath(String path) {
        if (Arrays.asList(File.listRoots()).contains(new File(path))) {
            return path;
        }

        return returnPath(path,
                FilenameUtils.getFullPath(new File(path).getAbsolutePath()));
    }

    /**
     * Normalize means manipulate and correct paths in the input path.
     *
     * @param path   The path you want to normalize.
     * @param unixOS If you are using unix like operating systems like Mac 0S or Linux, set this argument to true.
     * @return The normalized path that you get to this method.
     */
    public String normalize(String path, boolean unixOS) {
        return returnPath(path,
                FilenameUtils.normalize(path, unixOS));
    }
}
