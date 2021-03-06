package ru.mipt.java2016.homework.g595.ulyanin.task2;

import ru.mipt.java2016.homework.tests.task2.StudentKey;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author ulyanin
 * @since 31.10.16.
 */
public class StudentKeySerializer implements Serializer<StudentKey> {
    private static StudentKeySerializer ourInstance = new StudentKeySerializer();

    public static StudentKeySerializer getInstance() {
        return ourInstance;
    }

    private StudentKeySerializer() { }

    @Override
    public void serialize(StudentKey data, DataOutputStream dataOutputStream) throws IOException {
        IntegerSerializer.getInstance().serialize(data.getGroupId(), dataOutputStream);
        StringSerializer.getInstance().serialize(data.getName(), dataOutputStream);
    }

    @Override
    public StudentKey deserialize(DataInputStream dataInputStream) throws IOException {
        return new StudentKey(
                IntegerSerializer.getInstance().deserialize(dataInputStream),
                StringSerializer.getInstance().deserialize(dataInputStream));
    }
}
