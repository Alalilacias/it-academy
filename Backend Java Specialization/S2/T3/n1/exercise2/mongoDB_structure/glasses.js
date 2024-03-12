db.createCollection('glasses',
validator:
{
  $jsonSchema: {
    bsonType: "object",
    required: ["brand", "prescription_left", 'prescription_right', "frame_type", "frame_color", "glass_color_left",
                "glass_color_right", "price", "supplier", "sales_information"],
    properties: {
      brand: { bsonType: "string" },
      prescription_left: { bsonType: "string" },
      prescription_right: { bsonType: "string" },
      frame_type: {
              bsonType: "string",
              enum: ["floating", "paste", "metallic"]
            },
      frame_color: { bsonType: "string" },
      glass_color_left: { bsonType: "string" },
      glass_color_right: { bsonType: "string" },
      price: { bsonType: "double" },
      supplier: { bsonType: "object",
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
                  },
      sales_information: {
              bsonType: "object",
              required: ["employee", "date", "time", "bought_by"],
              properties: {
                employee: { bsonType: "string" },
                date: { bsonType: "date" },
                time: { bsonType: "string"},
                bought_by: { bsonType: "objectId" }
              }
            }
    }
  }
}
)