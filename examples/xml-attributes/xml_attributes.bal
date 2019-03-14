import ballerina/io;

xmlns "http://ballerina.com/aa" as ns0;

public function main() {
    // Create an XML element that has attributes that are bound to a namespace as well as ones that are not.
    xml x1 = xml `<ns0:book ns0:status="available" count="5"/>`;
    io:println(x1);

    // A single attribute that is bound to a namespace can be accessed using its qualified name. 
    io:println(x1@[ns0:status]);

    // An attribute can also be accessed using the string representation of the qualified name. 
    string s = x1@["{http://ballerina.com/aa}status"];
    io:println(s);

    // An attribute that is not bound to a namespace can be accessed using the string representation of the name.
    io:println(x1@["count"]);

    // Access an attribute using a dynamic name.
    string attributeName = "count";
    io:println(x1@[attributeName]);

    // Update an attribute.
    x1@[ns0:status] = "Not Available";
    io:println(x1@[ns0:status]);

    // It is possible to get all the attributes at once. However, this cannot be assigned to any variable.
    io:println(x1@);

    // We can use x1@ syntax to get all attributes of a singleton xml element as a map.
    map<string>? attributeMap = x1@;
    io:println(attributeMap);
    io:println(attributeMap["count"]);

    // However if we apply @ operator to a XML sequence it will return NIL, because only XML elements have attributes.
    xml x2 = xml `<Person name="James" />`;
    xml x3 = x1 + x2;
    map<string>? attrMap2 = x3@;
    io:println(attrMap2);
}
