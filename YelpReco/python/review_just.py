import csv

with open ('/Users/MAC/Desktop/Big_Data_Project/review.csv', mode = 'wb') as fp:
    with open('/Users/MAC/Desktop/Big_Data_Project/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_review.csv', mode='rU') as f:
        reader = csv.reader(f)
        writer = csv.writer(fp, delimiter=',')
        fp.write('usr_id' + ','+'review_id'+ ','+'votes_cool'+ ','+'business_id'+ ','+'votes_funny'+ ','+'stars'+ ','+'date'+ ','+'type'+ ','+'votes_useful' + ',')

        for num, row in enumerate(reader):
            fp.write(row[0] + ','+row[1]+ ','+row[3]+ ','+row[4]+ ','+row[5]+ ','+row[6]+ ','+row[7]+ ','+row[8]+ ','+row[9] + '\n')
            #print num, row
