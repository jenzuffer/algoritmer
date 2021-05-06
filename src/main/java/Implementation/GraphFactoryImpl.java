package Implementation;

import Implementation.GraphImpl;
import Interfaces.Graph;
import Interfaces.GraphBuilder;
import Interfaces.GraphFactory;

import java.io.*;

public class GraphFactoryImpl implements GraphFactory
{
	@Override
	public GraphBuilder getNewBuilder(int verticeCount)
	{
		return new GraphImpl(verticeCount);
	}

	@Override
	public Graph readFromFile(String fileName) throws IOException
	{
		InputStream in = new FileInputStream(fileName);
		try (BufferedReader br
				     = new BufferedReader(new InputStreamReader(in))) {
			String line = br.readLine();
			int v = Integer.parseInt(line);
			GraphBuilder builder = getNewBuilder(v);
			line = br.readLine();
			int e = Integer.parseInt(line);
			for(int i = 0; i < e; ++i)
			{
				line = br.readLine();
				if (line == null) break;
				String[] vs = line.split(" ");
				int v1 = Integer.parseInt(vs[0]);
				int v2 = Integer.parseInt(vs[1]);
				float w = Float.parseFloat(vs[2]);
				builder.addEdge(v1, v2, w);
			}
			return builder.build();
		}
	}

}
