db.createCollection('suppliers',
validator:
{
  $jsonSchema: {
    bsonType: "object",
    required: ["name", "address", "telephone", "fax", "nif"],
    properties: {
      name: { bsonType: "string" },
      address: {
        bsonType: "object",
        required: ["street", "number", "city", "postal_code", "country"],
        properties: {
          street: { bsonType: "string" },
          number: { bsonType: "string" },
          city: { bsonType: "string" },
          postal_code: { bsonType: "string" },
          country: { bsonType: "string" }
        }
      },
      telephone: { bsonType: "string" },
      fax: { bsonType: "string" },
      nif: { bsonType: "string" }
    }
  }
}
)