# ITEM 34: ENUMS

PREREQUISITES

     https://www.baeldung.com/java-equals-hashcode-contracts
          You must override hashCode() in every class that overrides equals(). 
          Failure to do so will result in a violation of the general contract for Object.hashCode(),
          which will prevent your class from functioning properly in conjunction with all hash-based collections:
               HashMap, HashSet, and Hashtable.

          Collections such as HashMap and HashSet use a hashcode value of an object to determine how it 
          should be stored inside a collection, and the hashcode is used again in order to locate 
          the object in its collection.
          
          Hashing retrieval is a two-step process:
               Find the right bucket (using hashCode())
               Search the bucket for the right element (using equals() )
          When these contracts are not implemented correctly, retrieval is unreliable.
          Chapter 3 of Effective Java

DISADVANTAGES of CONSTANTS

     must use prefix (vs namespace)
     rigid 
     can't easily obtain string version of var name
     hard to iterate over all the int enum constants in a group


ADVANTAGES of ENUMS
    
    namespaces (identically named constants coexist peacefully)
    type safety
        Both the method argument type and value are checked (compile-time errors)
            invalid type or value (not a field in the enum type) results in compile time error

    instance-controlled / singletons (item 3): 
        Only one instance for each enumeration constant (via a public static final field)
        instance-controlled (page 6)    
        Can't be extended (final)

    are full-fledged classes
        can add arbitrary methods and fields 
        implement arbitrary interfaces
        use abstract methods for customized behavior

    provide high-quality implementations of all the Object methods
        implement Comparable (Item 14) and Serializable (Chapter 12)

    Returns an array of its values in the order they were declared via the static values method
    Generate Printable strings (field name) by calling their toString method.

     Other methods provided by Enum:
     https://www.tutorialspoint.com/java/lang/java_lang_enum.htm

RULES

    Enums are by their nature immutable, so all fields should be final, (See all rules in Item 17)

HOW TO USE:

    * Terms: each field in an enum is a "constant"
    * Know how to compare values: see EnumComparisonDemo.java
    * Use multiple attributes per member: see Planet.java
    * Use dynamic values for attributes
    * Use toString to generate printable strings of members
    * all enums, has a static values method that returns an array of its values in the order they were declared.
    

EXAMPLES

    ConstantsExample: 
        allows you to see what they mean by a constant.
    
    Orange.java and Apple.java:
        basic enum examples as a replacement for the Constants

    Level.java
          example with custom values 

    Planet:
        example with multiple attributes for each member and dynamic values
        
    WeightTable:
        Demonstrates use of Planet and the advantages of ENUMS

    Operation:
          4 function calculator (but inefficient and fragile implementation)
               add a new constatnt but forget to modify the switch
               needs error handler (new assertionError)
               
     OperationImproved
          4 function calculator
          better impl w/constant specific behavior (via abstract methods) 
               and constant specific data

     OperationImprovedImpl
          Implements OperationImproved
