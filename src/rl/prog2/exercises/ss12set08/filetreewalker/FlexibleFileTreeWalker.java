package rl.prog2.exercises.ss12set08.filetreewalker;

import java.io.File;
import java.io.IOException;

/**
 * This version of the file tree walker can be equipped with different
 * file processors. When walking through the file tree, the <code>process</code>
 * method of the processor is called for every file.
 * @author Ruediger Lunde
 */
public class FlexibleFileTreeWalker {
	private FileProcessor processor;
	
	/**
	 * Creates a file tree walker with a simple processor which just prints out
	 * full file name (with path) and file length.
	 */
	public FlexibleFileTreeWalker() {
		processor = new FileProcessor() {
			@Override
			public void process(File file) throws IOException {
				System.out.printf("%-100s%6d%n", file.getCanonicalPath(), file.length());
			}
		};
	}
	
	public FlexibleFileTreeWalker(FileProcessor processor) {
		this.processor = processor;
	}
	
	public void walk(String pathname) throws IOException {
		File[] files = new File(pathname).listFiles();
		if (files != null) {
			for (File file : files)
				if (file.isDirectory())
					walk(file.getCanonicalPath());
				else
					processor.process(file);
		}
	}
	
	/** Common interface for all file processors. */
	public static interface FileProcessor {
		void process(File file) throws IOException;
	}
}
