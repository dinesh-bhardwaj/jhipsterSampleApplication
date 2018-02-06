import { BaseEntity } from './../../shared';

export class RNS_BUYER_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public bUYERCODE?: string,
        public bUYERNAME?: string,
    ) {
    }
}
