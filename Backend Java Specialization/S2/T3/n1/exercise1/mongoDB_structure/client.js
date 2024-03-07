db.createCollection('clients',
validator:
{
  $jsonSchema: {
    bsonType: "object",
    required: ["name", "postal_address", "telephone", "email", "registration_date"],
    properties: {
      name: { bsonType: "string" },
      postal_address: { bsonType: "string" },
      telephone: { bsonType: "string" },
      email: { bsonType: "string" },
      registration_date: { bsonType: "date" },
      recommended_by: { bsonType: "objectId" },
      lastShoppings: {
        bsonType: "array",
        items: {
          bsonType: "objectId" // the glasses id is stored here, to avoid unlimited array.
          }
        }
      }
    }
  }
}

)