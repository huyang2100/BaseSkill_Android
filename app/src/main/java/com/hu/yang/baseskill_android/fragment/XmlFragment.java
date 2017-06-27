package com.hu.yang.baseskill_android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hu.yang.baseskill_android.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by yanghu on 2017/6/24.
 */

public class XmlFragment extends Fragment {

    private static final String FILE_XML_SAVE = "file_xml_save.xml";
    private static final String XML_KEY_STUDENT = "student";
    private static final String XML_KEY_NAME = "name";
    private static final String XML_KEY_NUMBER = "number";
    private static final String XML_KEY_AGE = "age";
    private static final String TAG = "XmlFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_xml, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XmlSerializer xmlSerializer = Xml.newSerializer();
                try {
                    FileOutputStream fos = getActivity().openFileOutput(FILE_XML_SAVE, Context.MODE_PRIVATE);
                    xmlSerializer.setOutput(fos, Xml.Encoding.UTF_8.name());
                    xmlSerializer.startDocument(Xml.Encoding.UTF_8.name(), true);
                    xmlSerializer.startTag(null, XML_KEY_STUDENT);

                    xmlSerializer.startTag(null, XML_KEY_NAME);
                    xmlSerializer.text("Yang");
                    xmlSerializer.endTag(null, XML_KEY_NAME);

                    xmlSerializer.startTag(null, XML_KEY_NUMBER);
                    xmlSerializer.text("001");
                    xmlSerializer.endTag(null, XML_KEY_NUMBER);

                    xmlSerializer.startTag(null, XML_KEY_AGE);
                    xmlSerializer.text("28");
                    xmlSerializer.endTag(null, XML_KEY_AGE);

                    xmlSerializer.endTag(null, XML_KEY_STUDENT);
                    xmlSerializer.endDocument();
                    fos.close();
                    Toast.makeText(getActivity(), "save success!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        view.findViewById(R.id.btn_parse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XmlPullParser xmlPullParser = Xml.newPullParser();
                try {
                    FileInputStream fis = getActivity().openFileInput(FILE_XML_SAVE);
                    xmlPullParser.setInput(fis, Xml.Encoding.UTF_8.name());
                    int eventType = xmlPullParser.getEventType();
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        String tag = xmlPullParser.getName();
                        if (eventType == XmlPullParser.START_TAG) {
                            if (XML_KEY_STUDENT.equals(tag)) {
                                Log.i(TAG, "XmlPullParser a new student");
                            } else if (XML_KEY_NAME.equals(tag)) {
                                Log.i(TAG, "XmlPullParser name " + xmlPullParser.nextText());
                            } else if (XML_KEY_AGE.equals(tag)) {
                                Log.i(TAG, "XmlPullParser age: " + xmlPullParser.nextText());
                            }
                        }

                        eventType = xmlPullParser.next();
                    }
                    fis.close();
                    Toast.makeText(getActivity(), "parse success!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
