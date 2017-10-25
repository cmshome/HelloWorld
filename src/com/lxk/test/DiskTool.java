package com.lxk.test;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * @author lxk on 2017/1/5
 */
public class DiskTool {

    public static void main(String[] args) throws SigarException {
        Sigar sigar = new Sigar();

        FileSystem[] fileSystemArray = sigar.getFileSystemList();
        for ( FileSystem fileSystem:fileSystemArray ) {
            System.out.println("fileSystem dirName：" + fileSystem.getDirName());//分区的盘符名称
            System.out.println("fileSystem devName：" + fileSystem.getDevName());//分区的盘符名称
            System.out.println("fileSystem typeName：" + fileSystem.getTypeName());// 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
            System.out.println("fileSystem sysTypeName：" + fileSystem.getSysTypeName());//文件系统类型，比如 FAT32、NTFS
            System.out.println("fileSystem options：" + fileSystem.getOptions());
            System.out.println("fileSystem flags：" + fileSystem.getFlags());
            System.out.println("fileSystem type：" + fileSystem.getType());

            FileSystemUsage usage;

            try {
                usage = sigar.getFileSystemUsage(fileSystem.getDirName());
            } catch (SigarException e) {//当fileSystem.getType()为5时会出现该异常——此时文件系统类型为光驱
                continue;
            }
            System.out.println("fileSystemUsage total：" + usage.getTotal() + "KB");// 文件系统总大小
            System.out.println("fileSystemUsage free：" + usage.getFree() + "KB");// 文件系统剩余大小
            System.out.println("fileSystemUsage used：" + usage.getUsed() + "KB");// 文件系统已使用大小
            System.out.println("fileSystemUsage avail：" + usage.getAvail() + "KB");// 文件系统可用大小
            System.out.println("fileSystemUsage files：" + usage.getFiles());
            System.out.println("fileSystemUsage freeFiles：" + usage.getFreeFiles());
            System.out.println("fileSystemUsage diskReadBytes：" + usage.getDiskReadBytes());
            System.out.println("fileSystemUsage diskWriteBytes：" + usage.getDiskWriteBytes());
            System.out.println("fileSystemUsage diskQueue：" + usage.getDiskQueue());
            System.out.println("fileSystemUsage diskServiceTime：" + usage.getDiskServiceTime());
            System.out.println("fileSystemUsage usePercent：" + usage.getUsePercent() * 100 + "%");// 文件系统资源的利用率
            System.out.println("fileSystemUsage diskReads：" + usage.getDiskReads());
            System.out.println("fileSystemUsage diskWrites：" + usage.getDiskWrites());
            System.err.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
    }
}
