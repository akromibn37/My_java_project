import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;

public class XXXXXXXXXXXXXXXX {

	public static void main(String[] args) throws FileNotFoundException {
		// Create serialize objects.
		
 
		
		Person james = new Person();
		james.id = 1;
		james.name = "james";
		james.surname = "sa";
		james.phone = "08000000";		
		
		List<String> src = new ArrayList<String>();
		src.add("msgpack");
		src.add("kumofs");
		src.add("viver");

		MessagePack msgpack = new MessagePack();
		// Serialize
		byte[] raw = msgpack.write(src);

		// Deserialize directly using a template
		List<String> dst1 = msgpack.read(raw, Templates.tList(Templates.TString));
		System.out.println(dst1.get(0));
		System.out.println(dst1.get(1));
		System.out.println(dst1.get(2));

		// Or, Deserialze to Value then convert type.
		Value dynamic = msgpack.read(raw);
		List<String> dst2 = new Converter(dynamic)
		    .read(Templates.tList(Templates.TString));
		System.out.println(dst2.get(0));
		System.out.println(dst2.get(1));
		System.out.println(dst2.get(2));
		
		 

	}

}
