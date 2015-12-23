import csv


with open ('/Users/MAC/Desktop/Big_Data_Project/business.csv', mode = 'wb') as fp:
    with open('/Users/MAC/Desktop/Big_Data_Project/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_business.csv', mode='rU') as f:
        reader = csv.reader(f)
        writer = csv.writer(fp, delimiter=',')
        fp.write('delivery' + ','+'latitude'+ ','+'longitude' + ','+'outdoor sitting'+ ','+'alcohol'+ ','+'payment types'+ ','+'parking lot'+ ','+'business id'+ ','+'name'+ ','+'state'+ ','+'take out'+ ','+'stars'+ ','+'category' + '\n')
        for num, row in enumerate(reader):
            if 'Restaurant' in row[9] and 'NC' in row[39]:
            #if 'Music' in row[9] and 'NC' in row[39]:
                fp.write(row[0]+ ','+row[10]+ ','+row[74]+','+row[11]+ ','+row[12]+ ','+row[14]+ ','+row[15]+ ','+row[16]+ ','+row[22]+ ','+row[39]+ ','+row[45]+ ','+row[65]+ ','+row[9] + '\n')
            #print num, row
           