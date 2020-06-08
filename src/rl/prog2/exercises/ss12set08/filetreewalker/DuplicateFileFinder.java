package rl.prog2.exercises.ss12set08.filetreewalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Tool for finding duplicate files. It calls the tree walker with a special
 * file processor, which sorts files by their names (without path). If files
 * exist with same name, same length, but different path, their full names are
 * printed out together with their size.
 * 
 * @author Ruediger Lunde
 */
public class DuplicateFileFinder {
	/**
	 * Starts the tool. Here, the parent of the current directory is used as
	 * root of the tree.
	 */
	public static void main(String[] args) throws IOException {
		MyProcessor processor = new MyProcessor();
		new FlexibleFileTreeWalker(processor).walk("..");
		processor.sortAndPrint();
	}

	private static class MyProcessor implements
			FlexibleFileTreeWalker.FileProcessor {
		HashMap<String, List<File>> fileMap = new HashMap<String, List<File>>();

		@Override
		public void process(File file) throws IOException {
			List<File> list = fileMap.get(file.getName());
			if (list == null) {
				list = new ArrayList<File>();
				fileMap.put(file.getName(), list);
			}
			list.add(file);
		}

		public void sortAndPrint() throws IOException {
			List<String> fileNames = new ArrayList<String>();
			fileNames.addAll(fileMap.keySet());
			// sort file names
			Collections.sort(fileNames);
			for (String fileName : fileNames) {
				List<File> fileList = fileMap.get(fileName);
				// sort files with equal name by length
				Collections.sort(fileList, new Comparator<File>() {
					@Override
					public int compare(File f1, File f2) {
						return new Long(f1.length()).compareTo(f2.length());
					}
				});
				if (fileList.size() > 1)
					printFilesWithEqualSize(fileList);
			}
		}

		private void printFilesWithEqualSize(List<File> fileList)
				throws IOException {
			File prev = null;
			boolean prevPrinted = false;
			for (File curr : fileList) {
				if (prev != null && prev.length() == curr.length()) {
					if (prevPrinted == false) {
						System.out.printf("%-100s%6d%n",
								prev.getCanonicalPath(), prev.length());
					}
					System.out.printf("%-100s%6d%n", curr.getCanonicalPath(),
							curr.length());
					prevPrinted = true;
				} else {
					prevPrinted = false;
				}
				prev = curr;
			}
		}
	}
}
