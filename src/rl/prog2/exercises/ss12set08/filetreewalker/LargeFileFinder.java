package rl.prog2.exercises.ss12set08.filetreewalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implements a tool for finding large files. It calls the file tree walker
 * with a special file processor, which orders files by size in descendant
 * order.
 * @author Ruediger Lunde
 *
 */
public class LargeFileFinder {
	/** Starts the tool. The current directory is used as root of the tree. */
	public static void main(String[] args) throws IOException {
		MyProcessor processor = new MyProcessor();
		new FlexibleFileTreeWalker(processor).walk(".");
		processor.sortAndPrint();
	}

	private static class MyProcessor implements
			FlexibleFileTreeWalker.FileProcessor {
		ArrayList<File> files = new ArrayList<File>();

		@Override
		public void process(File file) throws IOException {
			files.add(file);
		}

		public void sortAndPrint() throws IOException {
			Collections.sort(files, new Comparator<File>() {
				@Override
				public int compare(File f1, File f2) {
					return -new Long(f1.length()).compareTo(f2.length());
				}
			});
			for (File file : files)
				System.out.printf("%-100s%6d%n", file.getCanonicalPath(),
						file.length());
		}
	}
}
