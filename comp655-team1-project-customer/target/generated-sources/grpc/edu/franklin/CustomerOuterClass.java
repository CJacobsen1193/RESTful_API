// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer.proto
package edu.franklin;

public final class CustomerOuterClass {

    private CustomerOuterClass() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor internal_static_customer_Customer_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_customer_Customer_fieldAccessorTable;

    static final com.google.protobuf.Descriptors.Descriptor internal_static_customer_GetRandomCustomerRequest_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_customer_GetRandomCustomerRequest_fieldAccessorTable;

    static final com.google.protobuf.Descriptors.Descriptor internal_static_customer_UpdateCustomerResponse_descriptor;

    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_customer_UpdateCustomerResponse_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

    static {
        java.lang.String[] descriptorData = { "\n\016customer.proto\022\010customer\"S\n\010Customer\022\n" + "\n\002id\030\001 \001(\003\022\014\n\004name\030\002 \001(\t\022\r\n\005email\030\003 \001(\t\022" + "\017\n\007balance\030\004 \001(\002\022\r\n\005price\030\005 \001(\002\"&\n\030GetRa" + "ndomCustomerRequest\022\n\n\002id\030\001 \001(\003\")\n\026Updat" + "eCustomerResponse\022\017\n\007success\030\001 \001(\0102\252\001\n\017C" + "ustomerService\022M\n\021GetRandomCustomer\022\".cu" + "stomer.GetRandomCustomerRequest\032\022.custom" + "er.Customer\"\000\022H\n\016UpdateCustomer\022\022.custom" + "er.Customer\032 .customer.UpdateCustomerRes" + "ponse\"\000B\020\n\014edu.franklinP\001b\006proto3" };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new com.google.protobuf.Descriptors.FileDescriptor[] {});
        internal_static_customer_Customer_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_customer_Customer_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_customer_Customer_descriptor, new java.lang.String[] { "Id", "Name", "Email", "Balance", "Price" });
        internal_static_customer_GetRandomCustomerRequest_descriptor = getDescriptor().getMessageTypes().get(1);
        internal_static_customer_GetRandomCustomerRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_customer_GetRandomCustomerRequest_descriptor, new java.lang.String[] { "Id" });
        internal_static_customer_UpdateCustomerResponse_descriptor = getDescriptor().getMessageTypes().get(2);
        internal_static_customer_UpdateCustomerResponse_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(internal_static_customer_UpdateCustomerResponse_descriptor, new java.lang.String[] { "Success" });
    }
    // @@protoc_insertion_point(outer_class_scope)
}
