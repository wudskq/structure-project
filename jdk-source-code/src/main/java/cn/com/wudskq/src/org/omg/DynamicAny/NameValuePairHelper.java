package org.omg.DynamicAny;


/**
* org/omg/DynamicAny/NameValuePairHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u152/9742/corba/src/share/classes/org/omg/DynamicAny/DynamicAny.idl
* Thursday, September 14, 2017 2:32:49 AM PDT
*/

abstract public class NameValuePairHelper
{
  private static String  _id = "IDL:omg.org/DynamicAny/NameValuePair:1.0";

  public static void insert (org.omg.CORBA.Any a, org.omg.DynamicAny.NameValuePair that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.DynamicAny.NameValuePair extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (org.omg.DynamicAny.FieldNameHelper.id (), "FieldName", _tcOf_members0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_any);
          _members0[1] = new org.omg.CORBA.StructMember (
            "value",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (org.omg.DynamicAny.NameValuePairHelper.id (), "NameValuePair", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.DynamicAny.NameValuePair read (org.omg.CORBA.portable.InputStream istream)
  {
    org.omg.DynamicAny.NameValuePair value = new org.omg.DynamicAny.NameValuePair ();
    value.id = istream.read_string ();
    value.value = istream.read_any ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.DynamicAny.NameValuePair value)
  {
    ostream.write_string (value.id);
    ostream.write_any (value.value);
  }

}
